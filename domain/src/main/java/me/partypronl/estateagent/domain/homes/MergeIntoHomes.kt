package me.partypronl.estateagent.domain.homes

import me.partypronl.estateagent.domain.homes.model.Home
import me.partypronl.estateagent.domain.homes.model.Listing
import org.koin.core.annotation.Factory

@Factory
class MergeIntoHomes(
    private val getHomes: GetHomes,
    private val mergeListings: MergeListings,
) {

    suspend operator fun invoke(listings: List<Listing>): List<Home> {
        val existingHomes = getHomes()
        val existingHomesById = existingHomes.associateBy { it.listing.effectiveId }

        return listings.map { listing ->
            val existingHome = existingHomesById[listing.effectiveId]

            val mergedListing = if (existingHome != null) {
                mergeListings(existingHome.listing, listing)
            } else {
                listing
            }

            Home(mergedListing)
        }
    }
}
