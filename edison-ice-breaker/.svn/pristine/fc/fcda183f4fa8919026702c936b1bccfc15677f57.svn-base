#!/usr/bin/env python
import pbs
import sys
import commands

"""
return totalcore:busycore:downcore
"""

debug=False
#debug=True

def main():
    pbs_server = pbs.pbs_default()
    if not pbs_server:
        print "No default pbs server"
        sys.exit(-1)

    con = pbs.pbs_connect(pbs_server)
    nodes = pbs.pbs_statnode(con, "", "NULL", "NULL")

    totalcore=0
    busycore=0
    downcore=0

    i=0
    sum_loadave=0
    if debug:
        print "len(nodes)", len(nodes)
    for node in nodes:
        state=node.attribs[0]
        assert(state.name=='state')
        np=node.attribs[1]
        assert(np.name=='np')

        totalcore += int(np.value)
        if state.value=='down':
            downcore += int(np.value)
            continue

        jobs=None
        status=node.attribs[3]
        if status.name == 'jobs':
            jobs=status
            jobs.value, len(jobs.value.split(','))
            status=node.attribs[4]
        elif status.name == 'status':
            x=0
        else:
            assert(status.name=='status')
            sys.exit(-2)

        number_job = 0
        if state.value=='free':
            if jobs!=None: number_job = len(jobs.value.split(','))
            busycore += number_job
        elif state.value=='down':
            downcore += int(np.value)
        elif state.value=='job-exclusive':
            busycore += int(np.value)
            
        i+=1

    if debug:
        print "#############"
        print "totalcore", totalcore
        print "busycore", busycore
        print "downcore", downcore

    print "%d:%d:%d" % (totalcore, busycore, downcore)

main()