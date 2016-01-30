package luque.david.mymoviesapp.Adapters;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import luque.david.mymoviesapp.R;
import luque.david.mymoviesapp.models.Movie;

/**
 * Created by David on 22/1/16.
 */
public class MovieAdapter extends BaseAdapter {

    private List<Movie> mList;
    private Context mContext;

    public MovieAdapter(List<Movie> list, Context c){
        this.mList = list;
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.movie_grid_item, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.movie_image);
        TextView textView = (TextView) convertView.findViewById(R.id.nombre_pelicula);

        final Movie movie = getItem(position);
        imageView.setImageResource(R.drawable.movie);

        return convertView;

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Movie getItem(int position) {
        return mList.get(position);
    }
}
