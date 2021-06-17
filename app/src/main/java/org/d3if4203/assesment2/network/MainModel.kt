package org.d3if4203.assesment2.network

data class MainModel (
    val result: ArrayList<Result>
) {
    data class Result (val id: Int, val title: String, val image: String, val desc: String)
}
