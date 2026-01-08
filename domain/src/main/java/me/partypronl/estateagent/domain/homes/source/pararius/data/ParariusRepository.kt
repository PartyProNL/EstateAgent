package me.partypronl.estateagent.domain.homes.source.pararius.data

import me.partypronl.estateagent.domain.homes.model.Listing
import me.partypronl.estateagent.domain.homes.queries.model.SearchQuery

interface ParariusRepository {

    suspend fun getListings(query: SearchQuery): List<Listing>
}
