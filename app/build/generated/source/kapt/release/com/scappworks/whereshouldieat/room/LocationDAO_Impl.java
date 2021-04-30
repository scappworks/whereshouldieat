package com.scappworks.whereshouldieat.room;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocationDAO_Impl implements LocationDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Location> __insertionAdapterOfLocation;

  private final EntityDeletionOrUpdateAdapter<Location> __deletionAdapterOfLocation;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public LocationDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocation = new EntityInsertionAdapter<Location>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `location_table` (`location_name`,`category`,`always_open`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Location value) {
        if (value.getLocation_name() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLocation_name());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCategory());
        }
        if (value.getAlways_open() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlways_open());
        }
      }
    };
    this.__deletionAdapterOfLocation = new EntityDeletionOrUpdateAdapter<Location>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `location_table` WHERE `location_name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Location value) {
        if (value.getLocation_name() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLocation_name());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM location_table";
        return _query;
      }
    };
  }

  @Override
  public Object insertLocation(final Location location, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocation.insert(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final Location model, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLocation.handle(model);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Flow<List<Location>> getOrderedLocations() {
    final String _sql = "SELECT * FROM location_table ORDER BY location_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"location_table"}, new Callable<List<Location>>() {
      @Override
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "location_name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfAlwaysOpen = CursorUtil.getColumnIndexOrThrow(_cursor, "always_open");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Location _item;
            final String _tmpLocation_name;
            _tmpLocation_name = _cursor.getString(_cursorIndexOfLocationName);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpAlways_open;
            _tmpAlways_open = _cursor.getString(_cursorIndexOfAlwaysOpen);
            _item = new Location(_tmpLocation_name,_tmpCategory,_tmpAlways_open);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Location>> getFilteredLocationsSpecific(final String category,
      final String hours) {
    final String _sql = "SELECT * FROM location_table WHERE category LIKE ? AND always_open LIKE ? ORDER BY location_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    _argIndex = 2;
    if (hours == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, hours);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"location_table"}, new Callable<List<Location>>() {
      @Override
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "location_name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfAlwaysOpen = CursorUtil.getColumnIndexOrThrow(_cursor, "always_open");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Location _item;
            final String _tmpLocation_name;
            _tmpLocation_name = _cursor.getString(_cursorIndexOfLocationName);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpAlways_open;
            _tmpAlways_open = _cursor.getString(_cursorIndexOfAlwaysOpen);
            _item = new Location(_tmpLocation_name,_tmpCategory,_tmpAlways_open);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Location>> getFilteredLocationsUnspecific(final String category,
      final String hours) {
    final String _sql = "SELECT * FROM location_table WHERE category LIKE ? OR always_open LIKE ? ORDER BY location_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    _argIndex = 2;
    if (hours == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, hours);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"location_table"}, new Callable<List<Location>>() {
      @Override
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "location_name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfAlwaysOpen = CursorUtil.getColumnIndexOrThrow(_cursor, "always_open");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Location _item;
            final String _tmpLocation_name;
            _tmpLocation_name = _cursor.getString(_cursorIndexOfLocationName);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpAlways_open;
            _tmpAlways_open = _cursor.getString(_cursorIndexOfAlwaysOpen);
            _item = new Location(_tmpLocation_name,_tmpCategory,_tmpAlways_open);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
