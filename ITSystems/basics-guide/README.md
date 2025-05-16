## Command Line Git

- status
	- Shows the status of the local repository. This status includes:
		- number of local commits that have not been synced with remote (GitHub)
		- list of files in local folder that are NOT being tracked by git
		- list of files in local folder that have changes that need to be committed
	- `git status`
- log
	- Shows the log of previous commits. This includes:
		- The author of the commit
		- The date of the commit
		- The commit message of that particular commit
		- A unique commit identifier code
	- `git log`
- clone
	- Clones a repository into a new directory.
	- `git clone git@yourrepositoryhere`
- add
	- Adds file contents to the index.
		- If a file is added, then edited, and then pushed without re-adding, the previous state of the file is what gets pushed
	- `git add yourfile`
- rm
	- Removes files from the working tree and from the index.
	- `git rm myFile` This removes the file from the repo and the system at the same time.
	- `git rm --cached myfile` This removes git tracking of the file only.
- commit
	- Records changes to the repository.
	- `git commit -m "My commit message"`
- push
	- Updates remote refs along with associated objects.
	- `git push`
- fetch
	- Downloads objects and refs from another repository.
	- `git fetch <remote>`
- merge
	- Joins two or more development histories together.
		- Will take the specified branch in the git merge message and merge it with the current branch that you are in.
	- `git merge <branch>`
- pull
	- Fetches from and integrate with another repository or a local branch.
	- `git pull`
- branch
	- Lists, creates, or deletes branches.
	- `git branch nameOfBranch`
- tag
	- Creates, lists, deletes or verifies a tag object signed with GPG.
	- `git tag -a myTag -m "text exmplaining tag"`
- checkout
	- Switches branches or restores working tree files.
	- `git checkout targetBranch`
- init
	- Creates an empty Git repository or reinitializes an existing one.
	- `git init`
- remote
	- Lists the names of each remote you have access to, with origin being the original repo that was cloned.
	- `git remote`

## git files and folders

- .git folder
	- Contains all of the files needed for a git repo
		- `hooks/` has example scripts
		- `info/` has the `exclude` file to ignore certain patterns
		- `objects/` has objects, which are:
			- files
			- directories
			- commits
		- `refs/` pointers for commits
		- `HEAD` file tracks the current branch
		- `config` file has configuration options
		- `description`file has a description of the repo
		- `index` file is a computer readable file for staging
- .gitignore file
	- Specifies specific files that the user does not want Git to track utilizing patterns.
	- Each line of the file contains a pattern that is used to ignore certain files.
## GitHub

- Pull Requests
	- On Github, when a branch is ready to merge back to the main branch or to another branch, someone you can click the green button that says "Make Pull Requet".  This will open a page that allows the user to make a comment about what is being merged and why.  After this request is made, the admin of the git repo can choose to confirm the pull request and merge the branch back to the original, or can choose to create a comment explaining why they don't want to.


## SSH

- SSH authentication to repositories
	- Create a SSH key pair with `ssh-keygen -o -t ed25519 -C "email@example.com"`
	- Copy the public key that was generated in the .ssh folder, and go to the settings tab in Github
	- Click add key, and paste the copied key in.
	- Use the Github SSh url to clone the repo in your system
- SSH authentication to AWS instance
	- Click on AWS Details page and downlaod the PEM file of the SSH key.
	- Click on AWS with the green light, then click on EC2, and Instances, and copy the IP address
	- In the terminal, type in `ssh -i <absolute/path/of/key.pem> ubuntu@<ipaddress>
- Using the `config` file in the `.ssh` folder
	- Used to make SSHing quicker and not needing to memorize information
		- Host starter
  		 	HostName 50.17.185.244 `the ip of the system SSHing to`
        	 	User ubuntu `name of the user on that system`
        	 	IdentityFile /Users/Trevor/labsuser.pem `location of the private key on my system needed to connect to the remote system`
        	 	Port 22 `optional specification of which port to use, SSH defaults to 22`

## Resources

- [Pro Git Book] (https://git-scm.com/book/en/v2)
- [.git Folder Info] (https://stackoverflow.com/questions/29217859/what-is-the-git-folder)
- [.gitignore Folder Info] (https://git-scm.com/docs/gitignore/en)
- [Github SSH] (https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/GitHub-SSH-Key-Setup-Config-Ubuntu-Linux)
