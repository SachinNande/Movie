package com.saveo.movies.model


data class RecyclerList(val items : ArrayList<RecyclerData>)
data class RecyclerData(val name : String,val description :String,val owner : com.saveo.movies.model.Owner)
data class Owner(val avatar_url:String)
