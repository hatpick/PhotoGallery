package demo.datapp.photogallery.helper;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hat on 12/18/15.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private float space;
    private int count;
    private Context context;

    public SpacesItemDecoration(Context context, float space, int count) {
        this.context = context;
        this.space = space;
        this.count = count;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = (int) SizeHelper.convertDpToPixel(space, context);
        if(parent.getChildLayoutPosition(view) < count)
            outRect.top = (int) SizeHelper.convertDpToPixel(space * 2, context);

        if(parent.getChildLayoutPosition(view) % count == 0)
            outRect.right = (int) SizeHelper.convertDpToPixel(space/count, context);
        else if(parent.getChildLayoutPosition(view) % count == count - 1)
            outRect.left = (int) SizeHelper.convertDpToPixel(space/count, context);
        else {
            outRect.right = (int) SizeHelper.convertDpToPixel(space/count, context);
            outRect.left = (int) SizeHelper.convertDpToPixel(space/count, context);
        }


    }
}
