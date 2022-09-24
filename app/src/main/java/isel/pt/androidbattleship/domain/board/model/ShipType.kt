package isel.pt.androidbattleship.domain.board.model

fun String.toShipTypeOrNull(): ShipType? {
    val shipList: List<ShipType> = try {
        ShipType.values
            .filter { it.squares == this.toInt() }
    }catch (e:NumberFormatException){
        ShipType.values
            .filter { it.name.contains(this) }
    }

    return if(shipList.isEmpty())null
    else shipList.first()
}

fun String.toShipType(): ShipType {
    val shipList: List<ShipType> = try {
        ShipType.values
            .filter { it.squares == this.toInt() }
    }catch (e:NumberFormatException){
        ShipType.values
            .filter { it.name.contains(this) }
    }

    return if(shipList.size == 1) shipList.first()
    else throw NoSuchElementException()
}



/**
 * All ship types allowed in the game.
 * @property name Ship type name.
 * @property squares Number of squares occupied vertically or horizontally.
 * @property fleetQuantity Number of ships of this type in the starting fleet.
 */
class ShipType private constructor(val name: String, val squares:Int, val fleetQuantity:Int) {

    companion object {

        val values = listOf(
            ShipType("Carrier",5,1),
            ShipType("Battleship",4,1),
            ShipType("Cruiser",3,1),
            ShipType("Destroyer",2,2),
            ShipType("Submarine",1,2)
        )


    }
}