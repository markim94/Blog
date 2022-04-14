package com.swedio.bindingadapter.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swedio.bindingadapter.R
import org.w3c.dom.Document

object BindingAdapterUtils {

    /**
     * glide 라이브러리를 이용한 맞춤 메소드 설정
     * : imageUrl, error 2개 값이 모두 할당되어야 사용한다. (requireAll = true)
     */
    @JvmStatic
    @BindingAdapter("imageUrl", "error")
    fun loadImage(imageView: ImageView, imageUrl: String, errorDrawable: Drawable) {
        Glide.with(imageView).load(imageUrl).error(errorDrawable).into(imageView)

    }

    /**
     * glide 라이브러리를 이용한 맞춤 메소드 설정
     * : imageUrl, error 2개 값 중에 1개 값이라도 들어온다면 사용된다. (requireAll = false)
     */
    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
    fun loadImageRequireNonAll(imageView: ImageView, imageUrl: String?, placeHolder: Drawable?) {
        if (imageUrl == null) {
            // 이미지 url이 없다. placeHolder만 들어왔다.
            imageView.setImageDrawable(placeHolder)

        } else {
            // 이미지 url은 있다. 단, placeHolder가 없을 수도 있다. (둘 다 들어올 경우도 있다.)
            Glide.with(imageView.context).load(imageUrl).placeholder(placeHolder).error(placeHolder).into(imageView)

        } // end if

    }


    /**
     * (맞춤 로직 예제 사용)
     * 좌측 패딩값 설정
     */
    @JvmStatic
    @BindingAdapter("android:paddingLeft")
    fun setPaddingLeft(view: View, padding: Int) {
        view.setPadding(padding, view.paddingTop, view.paddingRight, view.paddingBottom)
    }

    /**
     * (맞춤 로직 예제 사용2)
     * 힌트 텍스트 사이즈 작게 설정
     */
    @JvmStatic
    @BindingAdapter("purple_text")
    fun setPurpleText(view: TextView, txt: String) {
        view.text = txt
        view.setTextColor(view.context.getColor(R.color.purple_700))
    }


    @JvmStatic
    @BindingAdapter("bind_list")
    fun setBindList(recyclerView: RecyclerView, data: MutableList<Document>) {
        // TODO
    }




}
