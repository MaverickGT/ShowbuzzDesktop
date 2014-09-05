package media;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.test.basic.PlayerControlsPanel;

public class MediaPlayerVLC {
	EmbeddedMediaPlayer embeddedMediaPlayer;
	EmbeddedMediaPlayerComponent mediaPlayerComponent;
	MediaPlayerFactory mediaPlayerFactory;
	JFrame mainFrame;
/*	public static void main(final String[] args) {

		new MediaPlayerVLC("http://www.polisciuk.com/trailers/SexTape.mp4",
				"Need For Speed Trailer");
		
	}*/

	public MediaPlayerVLC(String link, String name) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
				"resources\\vlc");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		embeddedMediaPlayer = mediaPlayerComponent
				.getMediaPlayer();
		Canvas vSurface = new Canvas();
		vSurface.setBackground(Color.black);
		List<String> vlcArgs = new ArrayList<String>();
		vlcArgs.add("--no-plugins-cache");
		vlcArgs.add("--no-video-title-show");
		vlcArgs.add("--no-snapshot-preview");

		mediaPlayerFactory = new MediaPlayerFactory(
				vlcArgs.toArray(new String[vlcArgs.size()]));
		mediaPlayerFactory.setUserAgent("vlcj player");
		embeddedMediaPlayer.setVideoSurface(mediaPlayerFactory
				.newVideoSurface(vSurface));
		embeddedMediaPlayer.setPlaySubItems(true);
		final PlayerControlsPanel controlsPanel = new PlayerControlsPanel(
				embeddedMediaPlayer);

		mainFrame = new JFrame();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setBackground(Color.black);
		mainFrame.setTitle(name);
		mainFrame.setSize(1200, 800);
		mainFrame.addWindowListener(new WindowAdapter() {
			      public void windowClosing(WindowEvent evt) {
			          if(embeddedMediaPlayer != null) {
			             embeddedMediaPlayer.stop();
			              embeddedMediaPlayer = null;
			              
			              
			            }

			           
			            
			      }
			    });
		mainFrame.add(vSurface, BorderLayout.CENTER);
		mainFrame.add(controlsPanel, BorderLayout.SOUTH);
		mainFrame.setVisible(true);

		embeddedMediaPlayer.playMedia(link);

	}
}
