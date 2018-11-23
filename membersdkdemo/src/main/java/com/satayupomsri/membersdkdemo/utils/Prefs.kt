package com.satayupomsri.membersdkdemo.utils

import android.content.Context
import android.content.SharedPreferences
import com.satayupomsri.membersdkdemo.R

/**
 * Created by satayupomsri on 15/11/2018 AD.
 */
internal class Prefs (context: Context) {

    private val prefName = "com.satayupomsri.membersdkdemo.utils.prefs"
    private val mContext = context

    private val prefs: SharedPreferences = context.getSharedPreferences(prefName, 0)

    var memberData: MemberData
        get() = MemberData(
                prefs.getString(mContext.resources.getString(R.string.member_id_key), ""),
                prefs.getString(mContext.resources.getString(R.string.member_name_key), ""),
                prefs.getString(mContext.resources.getString(R.string.member_avatar_key), ""),
                prefs.getBoolean(mContext.resources.getString(R.string.member_is_sign_in_key), false)
        )
        set(MemberData) {
            prefs.edit().putString(mContext.resources.getString(R.string.member_id_key), MemberData.getMemberData().id).apply()
            prefs.edit().putString(mContext.resources.getString(R.string.member_name_key), MemberData.getMemberData().name).apply()
            prefs.edit().putString(mContext.resources.getString(R.string.member_avatar_key), MemberData.getMemberData().avatar).apply()
            prefs.edit().putBoolean(mContext.resources.getString(R.string.member_is_sign_in_key), MemberData.getMemberData().isSignIn).apply()
        }
}