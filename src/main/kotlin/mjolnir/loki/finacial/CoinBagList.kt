package mjolnir.loki.finacial

import kotlin.collections.ArrayList

class CoinBagList {

    companion object{
        private val list = ArrayList<CoinBag>()

        fun callList(): List<CoinBag>{
            list.add(CoinBag("11/02/2021", 2932348, 300.00))
            list.add(CoinBag("11/02/2021", 7364736, 800.00))
            list.add(CoinBag("11/02/2021", 8945835, 120.00))
            list.add(CoinBag("11/02/2021", 9443348, 400.00))

            return list
        }
    }
}