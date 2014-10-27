package ca.zitao.ln.ui.adapters

import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import ca.zitao.ln.models.persistent.Chapter
import android.widget.TextView

class SavedChaptersAdapter(val context : Context) : BaseAdapter() {
  val realm = Realm.getInstance(context)!!
  val chapters = realm.allObjects(javaClass<Chapter>())!!

  override fun getCount(): Int {
    return chapters.size
  }
  override fun getItem(i: Int): Any? {
    return chapters.get(i)
  }
  override fun getItemId(i: Int): Long {
    return i.toLong()
  }
  override fun getView(i: Int, v: View?, vg: ViewGroup): View? {
    val textView = TextView(context)
    val chapter = chapters.get(i)
    textView.setText(chapter.getId() + " " + chapter.getSource())
    return textView
  }
}
