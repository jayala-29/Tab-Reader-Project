# Tab-Reader-Project

## Introduction
The purpose of this project is to create an interpreter for standard 6 string tablature.

## Phase 1
Basic interpretation where the number of _ characters represents the
string number preceding the fret number on that particular string.

input 

0__2 

output

6 0

4 2

## Phase 2
Interpreter should be able to distinguish separate notes to emulate
basic timing.

input

0 000 000

output

6 0
<br /><br />

6 0

6 0

6 0
<br /><br />


6 0

6 0

6 0

## Phase 3
Interpreter should be able to distinguish single notes from chords.
Chords have the representation NOTE_1 | NOTE_2 ... | NOTE_N.

input

0^_2^__2 3^_5^__5

output

6 0 | 5 2 | 4 2
<br /><br />

6 3 | 5 5 | 4 5

## Phase 4
Interpreter should be able to recognize sequences of notes to be
repeated a specified amount of times. This functionality should have
the form /*SEQUENCE_OF_NOTES*NUMBER_TO_REPEAT/

input

0 /000(asterisk)2/

output

6 0
<br /><br />

6 0

6 0

6 0
<br /><br />


6 0

6 0

6 0
