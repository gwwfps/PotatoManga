package ca.zitao.ln.ui

import android.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.app.Activity
import ca.zitao.ln.R
import android.widget.EditText
import android.widget.Spinner
import ca.zitao.ln.models.Source
import android.widget.Toast
import io.realm.Realm
import ca.zitao.ln.models.persistent.Chapter
import ca.zitao.ln.ui.adapters.SourceSpinnerAdapter
import android.widget.ListView
import ca.zitao.ln.ui.adapters.SavedChaptersAdapter

public class SavedChaptersFragment() : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val chaptersView = inflater.inflate(R.layout.chapters_view, container, false)!!
    val context = chaptersView.getContext()!!
    val realm = Realm.getInstance(context)!!

    val savedChapters = chaptersView.findViewById(R.id.saved_chapters) as ListView
    val savedChaptersAdapter = SavedChaptersAdapter(context)
    savedChapters.setAdapter(savedChaptersAdapter)

    val spinner = chaptersView.findViewById(R.id.source_picker) as Spinner
    spinner.setAdapter(SourceSpinnerAdapter(context))

    val input = chaptersView.findViewById(R.id.id_input) as EditText

    val addButton = chaptersView.findViewById(R.id.add_chapter) as Button
    addButton.setOnClickListener { v ->
      val id = input.getText().toString()
      val source = spinner.getSelectedItem()!! as Source
      realm.beginTransaction()
      val chapter = realm.createObject(javaClass<Chapter>())!!
      chapter.setId(id)
      chapter.setSource(source.name())
      realm.commitTransaction()
      savedChaptersAdapter.notifyDataSetChanged()
    }

    val clearButton = chaptersView.findViewById(R.id.clear_chapters) as Button
    clearButton.setOnClickListener { v ->
      realm.beginTransaction()
      realm.clear(javaClass<Chapter>())
      realm.commitTransaction()
      savedChaptersAdapter.notifyDataSetChanged()
    }

    return chaptersView
  }

  override fun onAttach(activity: Activity?) {
    super.onAttach(activity)
//    val section = getArguments()!!.getInt(ARG_SECTION_NUMBER)
//    (activity as MainActivity).onSectionAttached(section)
  }

//  public fun newInstance(sectionNumber: Int): PlaceholderFragment {
//    val fragment = PlaceholderFragment()
//    val args = Bundle()
//    args.putInt(ARG_SECTION_NUMBER, sectionNumber)
//    fragment.setArguments(args)
//    return fragment
//  }
}