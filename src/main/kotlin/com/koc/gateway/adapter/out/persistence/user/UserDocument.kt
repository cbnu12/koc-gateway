package com.koc.gateway.adapter.out.persistence.user

import com.koc.gateway.domain.user.UserStatus
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

@Document(collection = "user")
data class UserDocument(
    @Id
    @Field("_id", targetType = FieldType.OBJECT_ID)
    var id: String?,
    var email: String,
    var password: String,
    var name: String,
    var status: UserStatus
)