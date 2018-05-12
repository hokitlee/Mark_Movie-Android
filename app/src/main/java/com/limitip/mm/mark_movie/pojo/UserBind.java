package com.limitip.mm.mark_movie.pojo;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class UserBind {
    public final static ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> userPsd = new ObservableField<>();
    public final ObservableField<String> sex = new ObservableField<>();
    public final ObservableInt phone = new ObservableInt();
    public final ObservableField<String> token = new ObservableField<>();
}
