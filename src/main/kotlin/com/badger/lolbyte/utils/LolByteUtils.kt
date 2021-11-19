package com.badger.lolbyte.utils

import com.badger.lolbyte.match.PlayerResponse
import kotlin.math.max

object LolByteUtils {
    private val validSpells = setOf(0, 1, 3, 4, 6, 7, 11, 12, 13, 14, 21, 30, 31, 32, 33, 34, 35, 36, 39, 50, 51, 52)
    private val validKeystones = setOf(8005, 8008, 8010, 8021, 8112, 8124, 8128, 8214, 8229, 8230, 8351, 8358, 8359, 8360, 8437, 8439, 8465, 9923)

    fun generateRank(tier: String, division: String): String {
        return "${tier[0].toUpperCase()}${tier.substring(1, tier.length).toLowerCase()} $division"
    }

    fun sanitizeSpell(id: Int): Int {
        if (id == 54) return 33 // Ultimates game mode hack
        return if (id in validSpells) id else 0
    }

    fun sanitizeKeystone(id: Int): Int {
        return if (id in validKeystones) id else 0
    }

    fun computeKda(player: PlayerResponse?): Double {
        if (player == null) return 0.0
        return player.kills.toDouble() + player.assists.toDouble() / max(player.deaths.toDouble(), 1.0)
    }

    fun divideInts(numerator: Int, denominator: Int): Int {
        return (numerator.toDouble() / denominator.toDouble() * 100).toInt()
    }
}
