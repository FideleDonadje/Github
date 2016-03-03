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

DIR *src_dir, *dest_dir;


int copy_file(char *old_filename, char  *new_filename)
{
    int src_fd, dst_fd, n, nbread;
    char * buffer[4096];
    char * src_path, dst_path;

    // Assume that the program takes two arguments the source path followed
    // by the destination path.

//    if (argn != 3) {
//        printf("Wrong argument count.\n");
//        exit(1);
 //   }

    src_path = old_filename;
    dst_path = new_filename;

    src_fd = open(src_path,O_RDONLY ,0);
    printf("%d",src_fd);
    dst_fd = open(dst_path, O_CREAT | O_WRONLY,0);
    printf("%d",dst_fd);
    while (nbread = read(src_fd, buffer, sizeof(buffer)), nbread > 0)
    {
        nbread = read(src_fd, buffer, sizeof(buffer));
        if (nbread == -1) {
            printf("Error reading file.\n");
            exit(1);
        }
        n = nbread;

        if (n == 0) break;

        nbread = write(dst_fd, buffer, n);
        if (nbread == -1) {
            printf("Error writing to file.\n");
            exit(1);
        }
    }

    close(src_fd);
    close(dst_fd);
}


int main (int argc, char* argv[])
{
    char  filename_src[101], filename_dest[101];

		printf("\nSource file: ");
		fgets(filename_src, 100,stdin);

		printf("\nDestination filename: ");
		fgets(filename_dest, 100,stdin);

		if(copy_file(filename_src, filename_dest) == 0)
			printf("Copy Successful\n");
		else
			fprintf(stderr, "Error during copy!");

//go through all the file of a directory
DIR   *d;
struct dirent *dir;
d = opendir(".");
if (d)
{
    while ((dir = readdir(d)) != NULL)
    {
        printf("%s\n", dir->d_name);
    }

closedir(d);
  }

  return(0);
}

