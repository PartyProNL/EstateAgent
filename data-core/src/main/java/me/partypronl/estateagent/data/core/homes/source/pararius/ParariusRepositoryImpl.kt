package me.partypronl.estateagent.data.core.homes.source.pararius

import me.partypronl.estateagent.domain.homes.model.Listing
import me.partypronl.estateagent.domain.homes.queries.model.SearchQuery
import me.partypronl.estateagent.domain.homes.source.pararius.data.ParariusRepository
import org.koin.core.annotation.Factory

@Factory
class ParariusRepositoryImpl(
    private val dataSource: ParariusDataSource,
) : ParariusRepository {

    override suspend fun getListings(query: SearchQuery): List<Listing> {
        return dataSource.getListings(query)
    }
}
