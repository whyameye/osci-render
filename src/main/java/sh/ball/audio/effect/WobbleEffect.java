package sh.ball.audio.effect;

import sh.ball.audio.FrequencyListener;
import sh.ball.shapes.Vector2;

// Plays a sine wave at the same frequency as provided by the FrequencyListener
// to apply an audio effect that when visualised makes the image slightly wobble
// because it is played at a similar frequency
public class WobbleEffect extends PhaseEffect implements FrequencyListener, SettableEffect {

  private static final double DEFAULT_VOLUME = 0.2;

  private double frequency;
  private double lastFrequency;
  private double volume;

  public WobbleEffect(int sampleRate, double volume) {
    super(sampleRate, 2);
    this.volume = Math.max(Math.min(volume, 1), 0);
  }

  public WobbleEffect(int sampleRate) {
    this(sampleRate, DEFAULT_VOLUME);
  }

  public void update() {
    frequency = lastFrequency;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }

  @Override
  public void updateFrequency(double leftFrequency, double rightFrequency) {
    lastFrequency = leftFrequency;
  }

  @Override
  public Vector2 apply(int count, Vector2 vector) {
    double theta = nextTheta();
    double delta = volume * Math.sin(frequency * theta);
    double x = vector.x + delta;
    double y = vector.y + delta;

    return new Vector2(x, y);
  }

  @Override
  public void setValue(double value) {
    this.volume = value;
  }
}
