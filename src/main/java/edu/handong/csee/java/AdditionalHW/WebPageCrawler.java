package edu.handong.csee.java.AdditionalHW;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class WebPageCrawler {

	private String url;
	private String directory;
	private boolean verbose;
	private boolean help;

	public static void main(String[] args) {
		WebPageCrawler ma = new WebPageCrawler();
		ma.run(args);
	}

	public void run(String[] args) {
		Options options = createOptions();

		if (parseOptions(options, args)) {
			if (help) {
				printHelp(options);
				return;
			}

			URLReader rd = new URLReader();
			HTMLmaker hm = new HTMLmaker();

			String info = rd.getInformationFromWeb(url);
			hm.makeHTMLfile(directory, info);

			// TODO list all files in the path

			if (verbose) {
				System.out.println("******The program make HTML file from URL");
				System.out.println("******You should appoint URL to access");
				System.out.println("******You should appoint directory");
				System.out.println("****************************");
				System.out.println("******SeongBin Made it******");
				System.out.println("****************************");

			}
		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			url = cmd.getOptionValue("u");
			directory = cmd.getOptionValue("d");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("d").longOpt("directory").desc("Set a directory to make result file").hasArg()
				.argName("directory name").required().build());

		options.addOption(Option.builder("u").longOpt("url").desc("URL you will access").hasArg().argName("url name")
				.required().build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose").desc("Display detailed messages!")
				// .hasArg() // this option is intended not to have an option value but just an
				// option
				.argName("verbose option")
				// .required() // this is an optional option. So disabled required().
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help").desc("Help").build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "make HTML file from URL";
		String footer = "\nPlease report issues at https://github.com/sungbin/WebPageCrawler/issues";
		formatter.printHelp("WebPageCrawler", header, options, footer, true);
	}

}
