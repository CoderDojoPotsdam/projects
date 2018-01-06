import sys
import pyglet
#import re
pyglet.options['audio'] = ("openal", "pulse", "directsound", "silent")
_note_fixed = 47
_fixed_pitch = 440
_notes_in_octave = 12

_speed = 60 / 120

f = open(sys.argv[1])

raw_program = f.read()

raw_program = raw_program.splitlines()

raw_program = [i.split("#")[0].strip() for i in raw_program]

copy = tuple(raw_program)

full_program = []

melodies = {}
last_melody = ""
played_melodies = []

played_notes = []
all_notes = []

offset = 0

for index, line in enumerate(copy):
	if not line:
		offset += 1
		#print(offset)

	elif line.startswith("melody "):
		start = index - offset
		last_melody = line.split()[1].split(":")[0]
		melodies[last_melody] = [start]
		offset += 1

	elif line == "end":
		melodies[last_melody].append(index - 1 - offset)
		offset += 1

	else:
		full_program.append(line.split(":",1))

	#print(repr(line))

print(full_program)
print(melodies)
		
running = True
played_melodies.append(["main",0,0,False,""])

while running:
	print("-----------------")
	played_notes = []

	for melody in played_melodies:
		print(melody)

		if melody[2] > 1:
			melody[2] -= 1

		elif melody[4] != "":
			pass

		else:
			if melody[2] == 1:
				melody[2] = 1
				melody[1] += 1

			while True:
				instruction = full_program[melodies[melody[0]][0] + melody[1]]
				command = instruction[0]
				print(instruction)

				if command == "play":
					played_melodies.append([instruction[1],0,0,False,""])

				elif command == "note":
					if int(instruction[1]) in played_notes:
						melody[3] = True
						break

					else:
						played_notes.append(int(instruction[1]))
					print(played_notes)

				elif command == "delay":
					melody[2] = int(instruction[1])
					break

				elif command == "wait":
					pass

				elif command == "text":
					print(instruction[1])

				melody[1] += 1

				if melodies[melody[0]][0] + melody[1] > melodies[melody[0]][1]:
					melody[3] = True
					break

	all_notes.append(played_notes)

	for i in range(len(played_melodies) - 1, -1, -1):
		if played_melodies[i][3]:
			del played_melodies[i]

	#print(played_melodies)
	if len(played_melodies) == 0:
		break

	#print(played_notes)

print(all_notes)
frequencies = []

for notes in all_notes:
	freq = []

	for note in notes:
		pitch = (2 ** (note / _notes_in_octave) * _fixed_pitch) / 2 ** (_note_fixed / _notes_in_octave)
		freq.append(pitch)

	frequencies.append(freq)

print(frequencies)

point_in_melody = 0

def play_notes(dt):
	global frequencies,point_in_melody

	envelope = pyglet.media.procedural.ADSREnvelope(0.01,0.09,0.2,0.7)

	for pitch in frequencies[point_in_melody]:
		print(pitch)
		playing_note = pyglet.media.procedural.Sine(duration = _speed, frequency = pitch)
		playing_note.play()

	point_in_melody += 1

	if point_in_melody >= len(frequencies):
		pyglet.app.exit()

pyglet.clock.schedule_interval(play_notes,_speed)

pyglet.app.run()