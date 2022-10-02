package isel.pt.androidbattleship.domain.board.model

import isel.pt.androidbattleship.domain.board.coord.Position

enum class Player {
    ONE,
    TWO;

    fun other() =
        if(this == ONE)TWO
        else ONE
}

