package ardents.workmanagementsystem.utils

import android.content.Context
import ardents.workmanagementsystem.Model.LoginModel

class SharedPrefManager(context:Context) {

    private val SHARED_PREF_LOGIN="login"
    val LOGIN_RESPONSE="response"
    val LOGIN_MAIL="email"
    var mContext: Context
    init {
        mContext=context
    }
    companion object{
        private var mInstance:SharedPrefManager?=null

        @Synchronized
        fun getInstance(context: Context):SharedPrefManager{
            if (mInstance==null){
                mInstance= SharedPrefManager(context)
            }
            return mInstance!!
        }
    }

    fun setLoginResponse(response:String){
        val sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_LOGIN,Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putString(LOGIN_RESPONSE,response)
        editor.apply()
    }

    fun setLoginMail(mail:String){
        val sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_LOGIN,Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putString(LOGIN_MAIL,mail)
        editor.apply()
    }

    fun getLoginResponse():String? {
        val sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_LOGIN,Context.MODE_PRIVATE)
      //  val response=sharedPreferences.getString(LOGIN_RESPONSE,null)
        return sharedPreferences.getString(LOGIN_RESPONSE,null)
    }
    fun getLoginMail():String? {
        val sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_LOGIN,Context.MODE_PRIVATE)
        //  val response=sharedPreferences.getString(LOGIN_RESPONSE,null)
        return sharedPreferences.getString(LOGIN_MAIL,null)
    }

    fun clearLoginResponse() {
        val sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_LOGIN, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear().commit()
        editor.apply()

    }

}
