package me.partypronl.estateagent.domain.homes.source.pararius

import me.partypronl.estateagent.domain.homes.model.Listing
import me.partypronl.estateagent.domain.homes.queries.model.SearchQuery
import me.partypronl.estateagent.domain.homes.source.model.ListingsSource
import me.partypronl.estateagent.domain.homes.source.pararius.data.ParariusRepository
import org.koin.core.annotation.Factory

@Factory
class ParariusSource(
    private val repository: ParariusRepository,
) : ListingsSource {

    override suspend fun getListings(query: SearchQuery): List<Listing> {
        return repository.getListings(query)
    }
}
