Team CaNeFaitRien
======

What you need to do for now:

http://try.github.com/levels/1/challenges/1

I recommend working through this tutorial to get a hang of git. While you working through it, be sure to read the instructions & advices, very helpful. This should not take you long to learn this tool. You're gonna love it, trust me!  

  
Below is just the summary of some useful git command  

$ cd [directory]  
$ mkdir canefaitrien  
$ cd canefaitrien  
$ git clone https://github.com/lamson6592/canefaitrien.git  
  
  
After you modified files  
// to check what's changed since last commit    
$ git status  
  
// add each modified file   
$ git add [file-name]  

// add all new or modified files  
$ git add --all  
  
// when happy with your job and added all modified files  
$ git commit -m "message goes here"  
  
NOTE: commit often is good!  
  
  
// create new branch & switch to that branch  
$ git checkout -b [branch]  
  
// show list of branches  
$ git branch  
  
// switch to branch  
$ git checkout [branch] 
  
  
// when ready to merge branch, switch to master branch  
$ git checkout master  
  
// pull latest version  
$ git pull  
  
// merge branch to master in local repository  
$ git merge [branch]  
  
// delete a branch  
$ git branch -d [branch]
 
// push to master  
// only do once so next time can use "git push"  
$ git push -u origin master  
   
$ git push  

// change back to how a file was at the last commit  
$ git checkout -- <target>  


$ git branch clean_up
