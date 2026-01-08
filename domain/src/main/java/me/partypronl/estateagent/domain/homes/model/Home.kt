package me.partypronl.estateagent.domain.homes.model

data class Home(
    val listing: Listing,
    val state: State = State.AwaitingRating,
) {

    enum class State {

        AwaitingRating,
        Uninterested,
        Interested,
        Reacted,
        Rejected,
        Accepted,
    }
}
