package me.partypronl.estateagent.domain.homes

import me.partypronl.estateagent.domain.homes.data.HomesRepository
import me.partypronl.estateagent.domain.homes.model.Home
import org.koin.core.annotation.Factory

@Factory
class SyncListings(
    private val getListings: GetListings,
    private val mergeListings: MergeListings,
    private val mergeIntoHomes: MergeIntoHomes,
    private val repository: HomesRepository,
) {

    suspend operator fun invoke() {
        val listings = getListings()
        val merged = mergeListings(listings)
        val homes = mergeIntoHomes(merged)

        repository.saveHomes(homes)

        // TODO Status bar updates
    }
}
