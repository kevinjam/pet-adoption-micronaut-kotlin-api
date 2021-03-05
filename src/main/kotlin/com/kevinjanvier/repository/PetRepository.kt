package com.kevinjanvier.repository

import com.kevinjanvier.entity.PetModel
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.InsertOneResult
import com.mongodb.client.result.UpdateResult
import org.bson.types.ObjectId
import javax.inject.Singleton

@Singleton
class PetRepository(
        private val mongoClient: MongoClient
) {
    fun create(petModel: PetModel): InsertOneResult? =
            getCollection()
                    .insertOne(petModel)

    fun findAll(): List<PetModel> =
            getCollection().find().toList()


    fun findById(id: String): PetModel? =
            getCollection()
                    .find(
                            Filters.eq("_id", ObjectId(id))
                    )
                    .toList()
                    .firstOrNull()

    fun findAllByPetId(id: String) : List<PetModel>
     = getCollection()
            .find(
                    Filters.eq("_id", ObjectId(id))
            ).toList()

    fun update(id: String, update: PetModel): UpdateResult? =
            getCollection()
                    .replaceOne(
                            Filters.eq("_id", ObjectId(id)),
                            update
                    )

    fun deleteById(id: String): DeleteResult? =
            getCollection()
                    .deleteOne(
                            Filters.eq("_id", ObjectId(id))
                    )

    private fun getCollection() =
            mongoClient
                    .getDatabase("pet_db")
                    .getCollection("pets", PetModel::class.java)
}
