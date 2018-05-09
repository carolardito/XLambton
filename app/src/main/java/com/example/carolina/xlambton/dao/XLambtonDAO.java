package com.example.carolina.xlambton.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.carolina.xlambton.model.Agents;
import com.example.carolina.xlambton.model.Historical;
import com.example.carolina.xlambton.model.Photos;
import com.example.carolina.xlambton.model.User;

import java.util.ArrayList;
import java.util.List;

public class XLambtonDAO extends SQLiteOpenHelper {

    public XLambtonDAO(Context context) {
        super(context, "XLambtonDB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Login" +
                "(id        INTEGER PRIMARY KEY, " +
                "user       TEXT NOT NULL, " +
                "password    TEXT NOT NULL)";
        db.execSQL(sql);

        sql = "CREATE TABLE Agents" +
                "(id        INTEGER PRIMARY KEY," +
                "name       TEXT NOT NULL," +
                "level      TEXT NOT NULL," +
                "agency     TEXT NOT NULL," +
                "website    TEXT," +
                "country    TEXT," +
                "phone      TEXT," +
                "address    TEXT," +
                "photo      TEXT)";
        db.execSQL(sql);

        sql = "CREATE TABLE Historical" +
                "(id                INTEGER PRIMARY KEY," +
                "agentID            INTEGER NOT NULL," +
                "missionName        TEXT NOT NULL," +
                "date               TEXT NOT NULL," +
                "status             TEXT NOT NULL)" ;
        db.execSQL(sql);

        /*sql = "CREATE TABLE Photos" +
                "(id                INTEGER PRIMARY KEY," +
                "agentdID           INTEGER NOT NULL," +
                "missionPhoto       TEXT NOT NULL," +
                "missionPhotoName   TEXT NOT NULL)" ;*/
        sql = "CREATE TABLE Photos" +
                "(id                INTEGER PRIMARY KEY," +
                "agentdID           INTEGER NOT NULL," +
                "missionPhoto1       TEXT NOT NULL," +
                "missionPhoto2       TEXT NOT NULL," +
                "missionPhoto3       TEXT NOT NULL," +
                "missionPhoto4       TEXT NOT NULl)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Login";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS Agents";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS Historical";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS Photos";
        db.execSQL(sql);
        onCreate(db);
    }

    // LOGIN
    public void dbInsert(User login) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues loginData = getContentValues(login);

        db.insert("Login", null, loginData);
    }
    @NonNull
    private ContentValues getContentValues(User login) {
        ContentValues loginData = new ContentValues();
        loginData.put("user", login.getUser());
        loginData.put("password", login.getPassword());
        return loginData;
    }

    public List<User> dbSearchUser() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Login;";

        Cursor c = db.rawQuery(sql, null);
        List<User> userList = new ArrayList<User>();

        while (c.moveToNext()) {
            User login = new User();

            login.setId(c.getLong(c.getColumnIndex("id")));
            login.setUser(c.getString(c.getColumnIndex("user")));
            login.setPassword(c.getString(c.getColumnIndex("password")));

            userList.add(login);
        }
        c.close();

        return userList;
    }

    public void dbDelete(User login) {
        SQLiteDatabase db = getWritableDatabase();

        String[] param = {login.getId().toString()};
        db.delete("Login", "id = ?", param);
    }

    public void dbAlter(User login) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues userData = getContentValues(login);

        String[] param = {login.getId().toString()};
        db.update("Login", userData, "id = ?", param);
    }

    // AGENTS
    public void dbInsert(Agents agent) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues loginData = getContentValues(agent);

        db.insert("Agents", null, loginData);
    }
    @NonNull
    private ContentValues getContentValues(Agents agent) {
        ContentValues data = new ContentValues();
        data.put("name", agent.getName());
        data.put("level", agent.getLevel());
        data.put("agency", agent.getAgency());
        data.put("website", agent.getWebsite());
        data.put("country", agent.getCountry());
        data.put("phone", agent.getPhone());
        data.put("address", agent.getAddress());
        data.put("photo", agent.getPhoto());
        return data;
    }

    public List<Agents> dbSearchAgents() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Agents;";

        Cursor c = db.rawQuery(sql, null);
        List<Agents> agentsList = new ArrayList<Agents>();

        while (c.moveToNext()) {
            Agents agents = new Agents();

            agents.setId(c.getLong(c.getColumnIndex("id")));
            agents.setName(c.getString(c.getColumnIndex("name")));
            agents.setLevel(c.getString(c.getColumnIndex("level")));
            agents.setAgency(c.getString(c.getColumnIndex("agency")));
            agents.setWebsite(c.getString(c.getColumnIndex("website")));
            agents.setCountry(c.getString(c.getColumnIndex("country")));
            agents.setPhone(c.getString(c.getColumnIndex("phone")));
            agents.setAddress(c.getString(c.getColumnIndex("address")));
            agents.setPhoto(c.getString(c.getColumnIndex("photo")));

            agentsList.add(agents);
        }
        c.close();

        return agentsList;
    }

    public void dbDelete(Agents agents) {
        SQLiteDatabase db = getWritableDatabase();

        String[] param = {agents.getId().toString()};
        db.delete("Agents", "id = ?", param);
    }

    public void dbAlter(Agents agents) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues userData = getContentValues(agents);

        String[] param = {agents.getId().toString()};
        db.update("Agents", userData, "id = ?", param);
    }

    // HISTORICAL
    public void dbInsert(Historical historical) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues historicalData = getContentValues(historical);

        db.insert("Historical", null, historicalData);
    }
    @NonNull
    private ContentValues getContentValues(Historical historical) {
        ContentValues data = new ContentValues();
        data.put("agentID", historical.getAgentID());
        data.put("missionName", historical.getMissionName());
        data.put("date", historical.getDate());
        data.put("status", historical.getStatus());
        return data;
    }

    public List<Historical> dbSearchHistorical() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Historical;";

        Cursor c = db.rawQuery(sql, null);
        List<Historical> historicalList = new ArrayList<Historical>();

        while (c.moveToNext()) {
            Historical historical = new Historical();

            historical.setId(c.getLong(c.getColumnIndex("id")));
            historical.setAgentID(c.getLong(c.getColumnIndex("agentID")));
            historical.setMissionName(c.getString(c.getColumnIndex("missionName")));
            historical.setDate(c.getString(c.getColumnIndex("date")));
            historical.setStatus(c.getString(c.getColumnIndex("status")));

            historicalList.add(historical);
        }
        c.close();

        return historicalList;
    }

    public void dbDelete(Historical historical) {
        SQLiteDatabase db = getWritableDatabase();

        String[] param = {historical.getId().toString()};
        db.delete("Historical", "id = ?", param);
    }

    public void dbAlter(Historical historical) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues userData = getContentValues(historical);

        String[] param = {historical.getId().toString()};
        db.update("Historical", userData, "id = ?", param);
    }

    // PHOTOS
    public void dbInsertPhotos(Photos photos) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues photosData = getContentValues(photos);

        db.insert("Photos", null, photosData);
    }
    @NonNull
    private ContentValues getContentValues(Photos photos) {
        ContentValues data = new ContentValues();
        data.put("agentdID", photos.getAgentID());
        data.put("missionPhoto1", photos.getMissionPhoto1());
        data.put("missionPhoto2", photos.getMissionPhoto2());
        data.put("missionPhoto3", photos.getMissionPhoto3());
        data.put("missionPhoto4", photos.getMissionPhoto4());

        /*data.put("missionPhoto", photos.getMissionPhoto());
        data.put("missionPhotoName", photos.getMissionPhotoName());*/

        return data;
    }

    public List<Photos> dbSearchPhotos() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Photos;";

        Cursor c = db.rawQuery(sql, null);
        List<Photos> photosList = new ArrayList<Photos>();

        while (c.moveToNext()) {
            Photos photos = new Photos();

            photos.setId(c.getLong(c.getColumnIndex("id")));
            photos.setAgentID(c.getLong(c.getColumnIndex("agentdID")));
            photos.setMissionPhoto1(c.getString(c.getColumnIndex("missionPhoto1")));
            photos.setMissionPhoto2(c.getString(c.getColumnIndex("missionPhoto2")));
            photos.setMissionPhoto3(c.getString(c.getColumnIndex("missionPhoto3")));
            photos.setMissionPhoto4(c.getString(c.getColumnIndex("missionPhoto4")));
            /*photos.setMissionPhoto(c.getString(c.getColumnIndex("missionPhoto")));
            photos.setMissionPhotoName(c.getString(c.getColumnIndex("missionPhotoName")));*/

            photosList.add(photos);
        }
        c.close();

        return photosList;
    }

    public void dbDelete(Photos photos) {
        SQLiteDatabase db = getWritableDatabase();

        String[] param = {photos.getId().toString()};
        db.delete("Photos", "id = ?", param);
    }

    public void dbAlter(Photos photos) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues userData = getContentValues(photos);

        String[] param = {photos.getId().toString()};
        db.update("Photos", userData, "id = ?", param);
    }
}
