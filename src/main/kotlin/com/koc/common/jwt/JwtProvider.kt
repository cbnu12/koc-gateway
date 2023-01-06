package com.koc.common.jwt

import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.security.Key
import java.util.*

class JwtProvider {
    companion object {
        private const val secretKey: String = "koc-secretKey-cbnu-13jlkbnrfidusn1340r13nr031idn"
        private const val ACCESS_TOKEN_EXPIRE_TIME: Long = 1000 * 60 * 30
        private const val REFRESH_TOKEN_EXPIRE_TIME: Long = 1000 * 60 * 60 * 24 * 7
        private val key: Key = Keys.hmacShaKeyFor(secretKey.toByteArray())
        private val parser: JwtParser = Jwts.parserBuilder().setSigningKey(key).build()
        private val log: Logger = LoggerFactory.getLogger(JwtProvider::class.java)

        fun createAccessToken(): String {
            return createToken(ACCESS_TOKEN_EXPIRE_TIME)
        }

        fun createRefreshToken(): String {
            return createToken(REFRESH_TOKEN_EXPIRE_TIME)
        }

        fun validate(token: String?): Boolean {
            return token?.parseClaimsJws(parser)?.
                body?.expiration?.before(Date())?: false
        }

        private fun createToken(tokenValidTime: Long): String {
            return Jwts.builder()
                .setIssuedAt(Date())
                .setExpiration(Date(Date().time + tokenValidTime))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact()
        }
    }
}

fun String.parseClaimsJws(parser: JwtParser): Jws<Claims> {
    return parser.parseClaimsJws(this)
}