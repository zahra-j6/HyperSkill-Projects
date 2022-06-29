# A needle in the hay
 Hard
 ## Description
Have you ever had to use one of those 2000+ page phone books full of various organizations and people's names, written in a small font and with multiple columns on each page? Finding the information you need in such books can be an ordeal. In fact, even computers struggle to search through the millions of entries in a directory.

In this project, you will create a phone book, implementing several algorithms, and comparing their efficiency when using a big dataset.

For this, you will need to download the file directory.txt that contains the phone numbers of over a million people in multiple cities.

At this stage, you should implement the simplest possible search to find the numbers of a few people whose names are listed in the file find.txt.

It takes a time to find all the records from the big file. We recommend you manually test your program with the simplified data: small_directory.txt and small_find.txt. But to pass all the tests you have to work with the big files above.

Note how long it takes you to do this when using a linear search so that you can compare results with other search methods.

To measure the time difference, you can use ```System.currentTimeMillis().```

Also notice that you don't need to read the file "directory.txt" again and again after each query. You should load all lines into memory and measure only the search process.

Please, do not keep the downloaded files inside your project directory because the server can reject large files and you will see the message "Failed to post submission to the Hyperskill".
## Example
```
Below is an example of how your output should look:

Start searching...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.
```

https://hyperskill.org/projects/63/stages/340/implement
