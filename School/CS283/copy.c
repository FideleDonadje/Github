//Fidele Donadje
//CS 283
//Lab3 Directory Copy

#include <stdio.h>
#include <unistd.h>
#include <sys/stat.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>



int copy_file(char *old_filename, char  *new_filename)
{
    int src_fd, dst_fd, n, nbread;
    char * buffer[4096];
    char * src_path, * dst_path;

    // Assume that the program takes two arguments the source path followed
    // by the destination path.

//    if (argn != 3) {
//        printf("Wrong argument count.\n");
//        exit(1);
 //   }

    src_path = old_filename;
    dst_path = new_filename;

 

    src_fd = open(src_path,O_RDONLY ,0);
    dst_fd = open(dst_path, O_CREAT | O_WRONLY,0);
    while (nbread = read(src_fd, buffer, sizeof(buffer)), nbread > 0)
    {
        nbread = read(src_fd, buffer, sizeof(buffer));
        if (nbread == -1) {
            printf("Error reading file.\n");
            return(1);
        }
        n = nbread;

        if (n == 0) break;

        nbread = write(dst_fd, buffer, n);
        if (nbread == -1) {
            printf("Error writing to file.\n");
            return(1);
        }
    }

    close(src_fd);
    close(dst_fd);
}


int main (int argc, char* argv[])
{
    char *dir_src;
    char *dir_dest;

        dir_src = argv[1];
        dir_dest = argv[2];

		
		//if(copy_file(filename_src, filename_dest) == 0)
			//printf("Copy Successful\n");
		//else
			//fprintf(stderr, "Error during copy!");

//go through all the file of a directory
char *source_filename, *destination_filename;
 DIR   *src, *dest;
struct dirent *dir;
src = opendir(dir_src);
dest = opendir(dir_dest);
if (src)
{
    while ((dir = readdir(src)) != NULL)
    {
 
        source_filename =dir->d_name;
        strcat(destination_filename,dir_dest);
        strcat(destination_filename,'/');
        strcat(destination_filename,dir->d_name);
        if (copy_file(source_filename,destination_filename) ==0);
          printf("Copy Successful\n");
		    else
			    fprintf(stderr, "Error during copy!");
        
    }

closedir(src);
  }

  return(0);
  return(0);
}

