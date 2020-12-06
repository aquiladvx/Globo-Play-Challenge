package com.debcomp.aql.globoplaychallenge.infra.util

import android.content.Context
import com.debcomp.aql.globoplaychallenge.R
import java.io.*


/*
 * Davi Áquila
 * aquiladvx
 *
 * 05/12/2020
 *
 */

class MyFileUtils {

    companion object {
        fun readFile(context: Context): String {
            var string: String? = ""
            val stringBuilder = StringBuilder()
            val `is`: InputStream = context.resources.openRawResource(R.raw.apikey)
            val reader = BufferedReader(InputStreamReader(`is`))
            while (true) {
                try {
                    if (reader.readLine().also { string = it } == null) break
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                stringBuilder.append(string)
            }
            `is`.close()
            return stringBuilder.toString()

        }
    }
}