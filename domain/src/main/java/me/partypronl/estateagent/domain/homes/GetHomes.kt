package me.partypronl.estateagent.domain.homes

import kotlinx.coroutines.flow.first
import me.partypronl.estateagent.domain.homes.data.HomesRepository
import me.partypronl.estateagent.domain.homes.model.Home
import org.koin.core.annotation.Factory

@Factory
class GetHomes(
    private val repository: HomesRepository,
) {

    suspend operator fun invoke(): List<Home> {
        return repository.observeHomes().first()
    }
}
