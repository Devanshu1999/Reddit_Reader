# Reddit Reader

A custom reddit reader which allows you to create your own account and have multiple custom profiles in it.

Add multiple subreddits to your profiles of our choice and each profile will display top 5 posts from each subreddits that you add to it.

A very convenient way of getting particular subreddits' information quickly.

\*\*\*SETTING UP DATABASE\*\*\*
This app requires MySQL Workbench to be installed on the machine (Preferrably v8.0).

For the connection, I have used "root" as username and "toor" ass password.

*These can be modified from the "persistence-mysql.properties" file present in the resource directory.*

To set up the table, there are two ways:-

    METHOD-1:
    -Use the "reddit_reader_dump.sql" dump file to make database and tables. This will fill some sample rows in the tables.

    METHOD-2:
    -Run the "sql_script.sql" script file. This will create empty tables. 

