#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: devin.schmidt_snhu
"""

from pymongo import MongoClient
from bson.objectid import ObjectId

class DatabaseAccess(object):
    """Class to perform CRUD operations on a Mongo Database"""
    
    """Initialize class, requires a username, password, port number, database, and collection
    to be specified when created"""
    def __init__(self, name: str, pWord: str, pNum: str, db: str, col: str):
        """Start the client"""
        self.client = MongoClient('mongodb://%s:%s@localhost:%s' %(name, pWord, pNum))
        """Assign the database to a variable"""
        self.database = self.client[db]
        """Assign the database.collection to a variable"""
        self.collection = self.database[col]
        
        
    """Function to update record(s)"""
    def update(self, search_key, search_value, update_key, new_value):
        """Verify that arguments are not None"""
        if search_key is not None:
            if search_value is not None:
                if update_key is not None:
                    if new_value is not None:
                        result = self.collection.update_many({search_key : search_value}, {'$set' : {update_key : new_value}})
                        return result.raw_result
        """Raise exceptions if any argument is None"""
        raise Exception('Arguments can not be None')
        return
    
    
    """Function to delete record"""
    def remove(self, key, value):
        """Verify key or value are not None"""
        if key is not None:
            if value is not None:
                result = self.collection.delete_many({key : value})
                return result.raw_result
        """Raise exception if key or value is None"""
        raise Exception('Key or value can not be None')
        return
        
    
    """Function to create and insert a record into the collection, requires data in a dictionary"""
    def create(self, data):
        """Check that data is present, will not fault for an empty dictionary"""
        if data is not None:
            result = self.collection.insert_one(data)
        else:
            """Raises an exception if data is None"""
            raise Exception('Nothing to write, data is empty')
            return False
        """Return the acknowledged portion of the insertion result, this is true or false"""
        return result.acknowledged
            
    
    """Function to find and return a record(s) from collection, requires a key/value pair for search"""
    def read(self, key, value):
        if key is not None:
            if value is not None:
                read_result = self.collection.find({key : value})
                return read_result
            else:
                raise Exception('Value can not be none')
                return
        else:
            raise Exception('Key can not be none')
            return
        raise Exception('key or value can not be none')
        return 
   
    
    
    """Function to return search with two values"""
    def read_2_fields(self, key1, value1, key2, value2):
        """Check for empty key/value pairs"""
        if(key1 == None):
            raise Exception("key can not be none")
            return
        elif(value1 == None):
                raise Exception("Value can no be None")
                return
        elif(key2 == None):
               raise Exception("key can not be none")
               return
        elif(value2 == None):
                raise Exception("key can not be none")
                return
        else:
           """Read Database and return result"""      
        read_result = self.collection.find({key1 : value1, key2 : value2})
        return read_result 
        
    
    
    """Function to read only one record"""
    def readOne(self, key, value):
        if key is not None:
            if value is not None:
                read_result = self.collection.find_one({key : value})
                return read_result
            else:
                raise Exception('Value can not be none')
                return
        else:
            raise Exception('Key can not be none')
            return
        raise Exception('key or value can not be none')
        return 
        
    
    
    """Reads all records in Database"""
    def readAll(self):
        """Read database and retrun records"""
        read_result = self.collection.find({})
        return read_result
     
        # -*- coding: utf-8 -*-

