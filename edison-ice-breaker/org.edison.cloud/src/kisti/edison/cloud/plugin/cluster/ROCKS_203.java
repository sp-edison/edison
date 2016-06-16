/**
 * 
 */
package kisti.edison.cloud.plugin.cluster;

import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.core.Result;
import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.core.TaskExecFailException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;

/**
 * @author admin
 *
 */
@Component("ROCKS_203")
public class ROCKS_203 implements ClusterAdapter {

	protected final Logger LOG = Logger.getLogger(this.getClass());
	
	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getName() {
		return "ROCKS_203";
	}
	
	@Override
	public Cluster getClusterRuntime(Cluster cluster) {
		
		Long numTotalCores = 0L;
		Long numDownCores = 0L;
		Long numBusyCores = 0L;
		
		int port = 22002;
		port = Integer.parseInt(cluster.getPort());
		
		ConnBean cb = new ConnBean(cluster.getIp(), "root", port, "/root/.ssh/id_rsa");
		
		SSHExec ssh = SSHExec.getInstance(cb);
		boolean ret = ssh.connect();
		
		if (ret == false) 
		{
			LOG.error("ssh.connect fail");
			return null;
		}
		
		String cmd = "/usr/local/bin/pbs-cores.py " + cluster.getQueues();
		
		Result res = null;
		try {
			res = ssh.exec(cmd);
		} catch (TaskExecFailException e) {
			e.printStackTrace();
			ssh.disconnect();
			return null;
		}
		
		if (res.isSuccess)
		{
//			LOG.info("system res: " + res.sysout);
			/***
			 * totalcores:busycores:downcores
			 */
			/***
			 * sysout trim is important!!!
			 */
			String[] cores = res.sysout.trim().split(":");
			
			numTotalCores = Long.parseLong(cores[0]);
			numBusyCores = Long.parseLong(cores[1]);
			numDownCores = Long.parseLong(cores[2]);
		}
		else
		{
			LOG.error(res.error_msg);
			ssh.disconnect();
			return null;
		}
		
		ssh.disconnect();
		
		cluster.getRuntime().setTotalCores(numTotalCores);
		cluster.getRuntime().setBusyCores(numBusyCores);
		cluster.getRuntime().setDownCores(numDownCores);
		cluster.getRuntime().setFreeCores((numTotalCores - numBusyCores - numDownCores));
		
		return cluster;
	}


}
