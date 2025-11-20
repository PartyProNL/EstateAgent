package me.partypronl.estateagent

import me.partypronl.estateagent.data.core.DataCoreModule
import me.partypronl.estateagent.data.local.DataLocalModule
import me.partypronl.estateagent.data.remote.DataRemoteModule
import me.partypronl.estateagent.domain.DomainModule
import me.partypronl.estateagent.presentation.PresentationModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [
        DomainModule::class,
        DataCoreModule::class,
        DataLocalModule::class,
        DataRemoteModule::class,
        PresentationModule::class,
    ]
)
@ComponentScan("me.partypronl.estateagent")
class KoinApplicationModule

