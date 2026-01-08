package me.partypronl.estateagent.data.core.homes.source.pararius

import me.partypronl.estateagent.domain.homes.model.Listing
import me.partypronl.estateagent.domain.homes.queries.model.SearchQuery

interface ParariusDataSource {

    suspend fun getListings(query: SearchQuery): List<Listing>
}
