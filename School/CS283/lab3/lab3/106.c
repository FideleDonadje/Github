#include <stdio.h>
#include <unistd.h>
#include <sys/stat.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

void statecheck(int fd)
{
    struct stat filestat;
    char *type, *readok;

    fstat(fd, &filestat);
    if (S_ISREG(filestat.st_mode)) /* Determine file type */
        type = "regular";
    else if (S_ISDIR(filestat.st_mode))
        type = "directory";
    else
        type = "other";
    if ((filestat.st_mode & S_IRUSR)) /* Check read access */
        readok = "yes";
    else
        readok = "no";
    printf("type: %s, read: %s\n", type, readok);
}
int main (int argc, char **argv)
 {
          int n;
          rio_t rio;
          char buf[MAXLINE];
          Rio_readinitb(&rio, STDIN_FILENO); 1
          while((n = Rio_readlineb(&rio, buf, MAXLINE)) != 0)
            Rio_writen(STDOUT_FILENO, buf, n); 1

 exit(0);
 }
