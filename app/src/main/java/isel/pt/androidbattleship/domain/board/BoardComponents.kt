package isel.pt.androidbattleship.domain.board

import isel.pt.androidbattleship.domain.board.coord.Position
import isel.pt.androidbattleship.domain.board.model.Player
import isel.pt.androidbattleship.domain.board.model.ShipType

data class Move(val player: Player, val position: Position)

enum class Arrangement {Vertical, Horizontal}