#!/bin/env python
"""
        argv[1] : cluster name such as kisti.baekdusan
        argv[2] : class name such as edison
        returns : totalcore(s):busycore(s):downcore(s)
"""
import sys
import commands

if len(sys.argv) != 2:
        cluster='kisti.baekdusan'
        class_name='edison'
else:
        cluster=sys.argv[1]
        class_name=sys.argv[2]

cmd='llclass -X %s | grep %s' % ( cluster, class_name)

"""
=================== Cluster kisti.baekdusan ====================================

Name                 MaxJobCPU     MaxProcCPU  Free   Max Description
                    d+hh:mm:ss     d+hh:mm:ss Slots Slots
--------------- -------------- -------------- ----- ----- ---------------------
No_class             undefined      undefined     0     0                       yes
edison               undefined      undefined   136   136 class for normal parallel jobs yes
--------------------------------------------------------------------------------
"Maximum Slots" value of the class "No_class" is constrained by the MAX_STARTERS limit(s).
"Free Slots" value of the class "No_class" is constrained by the MAX_STARTERS limit(s).
"""

out=commands.getoutput(cmd)
out2=out.split()
# out2[3] : Free
# out2[4] : Max
totalcore=int(out2[4])
busycore=totalcore - int(out2[3])
downcore=0

print "%d:%d:%d" % (totalcore, busycore, downcore)