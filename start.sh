#!/bin/bash
/usr/bin/xset -dpms
/usr/bin/xset s 0 0
/usr/bin/xset s noblank
/usr/bin/xrandr --output HDMI1 --mode 640x480 --pos 325x0
cd /home/green/oscilloscope
/bin/cp test1.osci /tmp/.
/usr/bin/java -jar osci-render.jar &
/usr/bin/python3 -m http.server &
/usr/bin/unclutter -idle 1 &
sleep 30
/usr/bin/chromium-browser --start-fullscreen --window-position=0,0 -kiosk --incognito --noerrdialogs --disable-translate --no-first-run --fast --fast-start --disable-infobars --disable-features=TranslateUI --password-store=basic --window-size=640,480 http://localhost:8000 &










