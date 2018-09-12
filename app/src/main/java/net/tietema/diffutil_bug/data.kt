package net.tietema.diffutil_bug


data class Box(val id: Int, val clicked:Boolean = false)

data class Section(val subList: List<Box>)
