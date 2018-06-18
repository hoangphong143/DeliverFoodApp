package com.example.minhnguyen.appfoodserver.Model;

import java.util.List;

/**
 * Created by MINHNGUYEN on 4/16/2018.
 */

public class MyResponse {
    public long multicast_id;
    public int success;
    public int failure;
    public int canonical_ids;
    public List<Result> results;
}
