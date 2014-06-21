#lone or update all a user's gists
# curl -ks https://gist.githubusercontent.com/fedir/5466075/raw/gist-backup.py | USER=fedir python
# USER=fedir python gist-backup.py

import json
import urllib
from subprocess import call
from urllib import urlopen
import os
USER = os.environ['USER']

u = urlopen('https://api.github.com/users/zyzyis/gists?page=2&per_page=500')
gists = json.load(u)
startd = os.getcwd()

print len(gists)

for gist in gists:
  gistd = gist['id']
  if os.path.isdir(gistd):
    os.chdir(gistd)
    call(['git', 'pull', 'git://gist.github.com/' + gistd + '.git'])
    os.chdir(startd)
  else:
    call(['git', 'clone', 'git://gist.github.com/' + gistd + '.git'])
