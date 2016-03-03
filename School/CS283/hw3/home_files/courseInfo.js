// READ ONLY
var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]

// Name, Tux ID, Office Hours, Visible on website; try to keep to one line for submitrc script, which parses this to come up with course admins in addition to wmm24
var TA = [
         "Alberto Uriarte", "au49@drexel.edu", "Thursdays 4-6 pm", 1,
         "Samuel Bever", "smb393@drexel.edu", "Wednesday 4-6 pm", 1,
         "Tim Day", "tjd62@drexel.edu", "Tuesday 3-5 pm", 1,
         "Dennis Shtatnov", "ds996@drexel.edu", "Monday 4-6 pm", 1,
         "C. Katsinis", "katsinis@drexel.edu", "TBA", 0
	 ]
// Section, Name, Email, Office Hours
var instructor = [
        "Section 001",
        "Constantine Katsinis",
        "katsinis@drexel.edu",
        "Monday 3-5 pm in UC 100H",
        "Section 002",
        "Constantine Katsinis",
        "katsinis@drexel.edu",
        "Monday 3-5 pm in UC 100H",
        "Section 003",
        "Constantine Katsinis",
        "katsinis@drexel.edu",
        "Monday 3-5 pm in UC 100H"
	]

// section, website
  var website = ["Section", "http://www.cs.drexel.edu/~ck47/2014-2015/cs283-wi1415" ]
//var website = [
//        "Section 001", "file://localhost/C:/USR/TC/CLASSES/CS283/cs283-wi1415",
//        "Section 002", "file://localhost/C:/USR/TC/CLASSES/CS283/cs283-wi1415",
//        "Section 003", "file://localhost/C:/USR/TC/CLASSES/CS283/cs283-wi1415"
//        ]

// Section, Time, Room
var meetingtime = [
        "Section 001", "M 06:00 pm - 08:50 pm", "Korman 105D",
        "Section 002", "R 06:30 pm - 09:20 pm", "Curtis 250A",
        "Section 003", "T 06:30 pm - 09:20 pm", "Rush 014"
        ]

// Date, Text
var announcements = [
        "01/05/2015", "Welcome to everyone!",
        "01/10/2015", "Resources and Projects pages have been updated. See email.",
        "01/30/2015", "New information on Chapter 11. See BBlearn announcement."
	]
var latestannouncement = getLatestAnnouncement()

// READ ONLY
function getLatestAnnouncement() {
	var annDate = new Date("1/1/1900")
  var i = 0

	for(i = 0; i < announcements.length; i += 2) {
		var thisAnnDate = new Date(announcements[i])
		if(thisAnnDate > annDate) {
			annDate = thisAnnDate
		}
	}

	return days[annDate.getDay()] + ", " + months[annDate.getMonth()] + " " + annDate.getDate() + ", " + annDate.getFullYear()
}

var credithours = "3 Lecture, 0 Lab, 3 Total"

// Authors, Title, Publisher, ISBN
var books = [
        "Randel Bryant and David O'Hallaron", "<a href=\"http://csapp.cs.cmu.edu/public/students.html\">Computer Systems: A Programmer's Perspective</a>, 2nd Edition", "Prentice Hall", "0136108040"
	]

var recbooks = [ 
       "W. Richard Stevens and Stephen A. Rago", "Advanced Programming in the UNIX Environment, 2nd Edition", "Addison Wesley", "0201433079",
       "Michael Kerrisk", "<a href=\"http://man7.org/tlpi/\">The Linux Programming Interface</a>", "No Starch Press", "978-1-59237-220-3"
       ]

var course_description = "This course introduces computer systems, including interaction of hardware and software through the operating system, from the programmer's perspective. Three fundamental abstractions are emphasized; processes, virtual memory, and files. These abstractions provide programmers a common interface to a wide variety of hardware devices. Topics covered include linking, system level I/O, concurrent programming, and network programming."

var prereqs = "CS265"

var coursenum = "CS283"
var coursename = "Systems Programming"

var shortterm = "winter2014-15"

var leftbar = [ 
       "Main Page", "index.html", 
       "Announcements", "announcements.html", 
       "Lectures", "lectures.html", 
       "Labs", "labs.html", 
       "Assignments and Study Guides", "assignments.html", 
       "Projects", "projects.html", 
       "Course Guidelines", "course_guidelines.html", 
       "Resources", "resources.html", 
       "Syllabus", "syllabus.html", 
       "Grading Policy", "grading_policy.html", 
//     "<b>Piazza Discussion Forum</b>", "http://piazza.com/class#" + shortterm + "/"+ coursenum.toLowerCase(),
       "BBLearn", "http://learn.dcollege.net", 
       "Getting and Using a Tux Account", "https://www.cs.drexel.edu/~kschmidt/Ref/csLogin.html"
       ]

var grades = [ 
       "Homework and Programming Assignments", "35%", 
       "Labs", "15%", 
       "Midterm Exam", "20%",
       "Final Exam", "20%", 
       "Project", "10%"
       ]

var grade_breakdown = ["A range (A+, A, A-)", "[90, 100)", "B range", "[80, 90)", "C range", "[70, 80)", "D range", "[60, 70)", "F range", "[0, 60)"]

var objectives = [ "To obtain practical skills in concurrency and multithreaded programming.", "To become familiar with and comfortable using the programming facilities of the operating system, including a) File system structures, b) Network / socket programming, c) Memory system and shared memory, d) Thread mechanisms, and e) I/O system structures.", "To operate in and self-manage in programming teams." ]

var audience = "This is a core computer science course required by all Computer Science majors. It should be taken in the 3rd year. This course is appropriate for students interested in modern computer architecture, computer systems and high performance computing."

var shouldKnow = [ "Programming constructs and data structures in C and/or C++.", "Effectively use of the Unix programming environment - shell, file system, scripts, pipes, regular expressions, filters, program development tools", "Use of effective procedures and tools for building, debugging, testing, tuning, and maintaining programs" ]

var willKnow = [ "Use, develop and become familiar with programming constructs that interface with the operating system to provide functionality to the programmer and the user", "Write portable systems-level applications", "Coordinate threads using shared memory and distributed message-passing on a variety of platforms" ]

var topics = [
       "Concurrency (Chapter 12)",
       "Process and Thread Management", 
       "Process Tables (Chapter 8)", 
       "Compilers, Linkers and Loaders (Chapter 7)", 
       "Memory Systems (Chapters 6, 9)",
       "File Systems (Chapter 10)",
       "Network Programming (Chapter 11)"
       ]

var submission_method = "All assignments must be submitted using BBLearn.  Grades will be reported using BBLearn."

var latePolicy = "<b>Officially, no late assignments will be accepted. Students are expected to do their assignments by themselves.</b> Assignments that are late are not accepted as a rule, but may be accepted for up to 50% credit under the appropriate circumstances.  No credit can be given for late assignments under any circumstances once the assignment was discussed in class (typically the class day following the due date).  Requesting an exemption to this policy at any time will result in a one-half letter grade reduction from the final grade per incident."

var csHonestyPolicy = "The CS Department Academic Honesty policy is in effect for this course.  Please see the policy at <a href=\"http://www.drexel.edu/cci/resources/current-students/undergraduate/policies/\">http://www.drexel.edu/cci/resources/current-students/undergraduate/policies/</a>."

// Submission Code on Submit, Assignment Name, Hyperlink, Due Date, Grader Number (used above in TA array as index to name)
// Keep this on one line for parsing in the toSubmitRC program
// Can do var projects as well
var assignments = [ 
       "H1", "Anagram Solver", "homework/H1-AnagramSolver.html", "01/29/2015", 4,
       "H2", "Problems from Chapter 10", "homework/H2-Chapter10.html", "02/05/2015", 4,
       "H3", "Problems from Chapter 11", "homework/H3-Chapter11.html", "02/12/2015", 4,
       "H4", "File I/O", "homework/H4-fileIO.html", "02/19/2015", 4,
       "H5", "Problems from Chapter 12", "homework/H5-Chapter12.html", "02/26/2015", 4,
       "H6", "Problems from Chapter 8", "homework/H6-Chapter8.html", "03/05/2015", 4,
       "H7", "Problems from Chapters 6 and 9", "homework/H7-Chapters6&9.html", "03/12/2015", 4,
       "EVAL", "Submit Your Course Evaluation Documentation Here", "", "9/4/2014", 4
       ]
var labs = [
       "L1", "svn Repository", "labs/L1-svn.html", "01/15/2015", 4,
       "L2", "Pointers and Dynamic Arrays", "labs/L2-PointersDynamicArrays.html", "01/22/2015", 4,
       "L3", "File I/O Programming", "labs/L3-FileManipulation.html", "02/05/2015", 4,
       "L4", "HTTP Client and Server", "labs/L4-httpClient.html", "02/19/2015", 4,
       "L5", "Concurrent Programming", "labs/L5-ConcurrentProgramming.html", "02/26/2015", 4,
       "L6", "Chat server and client", "labs/L6-Chat.html", "03/05/2015", 4
       ]
var projects = [
       "P1", "Project Introduction", "project/P1-index.html", "01/22/2015", 4,
       "P1", "Project Status Report", "project/P1-Project.html", "02/28/2015", 4,
       "P1", "Project Final Report", "project/P1-Project.html", "03/13/2015", 4
       ]
// order these by sections in meetingtime variable above
var final_date = [ "3/16/2015", "3/19/2015", "3/17/2015" ]
var final_time = [ "TBA", "TBA", "TBA" ]
var final_room = [ "TBA", "TBA", "TBA" ]

function finalString() {
        str = "";

        for(i = 0; i < final_date.length; i++) {
                str = str + "<b>" + meetingtime[3 * i] + "</b>: " + final_date[i] + " at " + final_time[i] + " in " + final_room[i]
                if(i < final_date.length - 1) {
                        str = str + "<br>"
                }
        }

        return str;
}

// Week Number, Title, Hyperlink, Readings, Notes
var lectures = [
	1, "Intro to C Programming with gcc", "../cs283/lectures/gcc.ppt", 
	   "<a href=\"../cs283/resources/code/ieees.c\">ieees.c</a><br><a href=\"../cs283/resources/code/ieeep.h\">ieeep.h</a>", "",
	2, "GDB and Valgrind", "../cs283/lectures/gdbvalgrind.ppt", "", "",
	3, "File I/O", "../cs283/lectures/fileio.ppt", "CSAPP Chapter 10", "",
	4, "File I/O", "../cs283/lectures/fileio.ppt", "CSAPP Chapter 10", "",
	5, "Network Programming", "../cs283/lectures/networkprog.ppt", "CSAPP Chapter 11", "",
	6, "Concurrency", "../cs283/lectures/concurrency.ppt", "CSAPP Chapter 12<br><a href=\"https://computing.llnl.gov/tutorials/pthreads/\">pthreads Tutorial</a><br>Barriers", "Midterm Exam",
	7, "Concurrency", "../cs283/lectures/concurrency.ppt", "CSAPP Chapter 12", "Last Week to Withdraw",
	7, "Process Management and Signals", "../cs283/lectures/procmgt.ppt", "CSAPP Chapter 8", "",
	8, "Interprocess Communication", "../cs283/lectures/ipc.ppt", 
	   "<a href=\"../cs283/resources/ipc.pdf\">IPC Reference</a><br><a href=\"../cs283/resources/ipctut.pdf\">IPC Tutorial</a><br><a href=\"../cs283/resources/code/race.c\">race.c</a><br><a href=\"../cs283/resources/code/sigusr.c\">sigusr.c</a><br><a href=\"../cs283/resources/code/tellwait_pipe.c\">tellwait_pipe.c</a><br><a href=\"../cs283/resources/code/tellwait_sig.c\">tellwait_sig.c</a><br><a href=\"../cs283/resources/code/tshm.c\">tshm.c</a><br><a href=\"../cs283/resources/code/unrace.c\">unrace.c</a>", "",
	8, "Writing a Shell", "../cs283/lectures/shell.ppt", "", "",
	9, "Memory and Cache", "../cs283/lectures/virtualmem.ppt", "CSAPP Chapters 6, 9", "",
	10, "Compiling, Linking and Loading", "../cs283/lectures/linking.ppt", "CSAPP Chapter 7", "",
	11, "Final Exam: " + finalString(), "", "", "Final Exam"
]

// boolean flag for mon, tue, we, thu, fri; for each section number
var class_days = [ 1,1,0,1,0 ]

var holidays = [ "1/19/2015" ]

var term_start = "1/5/2015"
var class_end = "3/16/2015"
var term_end = "3/21/2015"
