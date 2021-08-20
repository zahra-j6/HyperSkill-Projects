# Write your code here
#Stage #1: Hello, Hangman
import random

print('H A N G M A N')
list=['python', 'java', 'kotlin', 'javascript']
guess=random.choice(list)
lives=8
word=''
not_word=''
length=len(guess)
for i in range(0,length):
    word=word+'-'
choices=input('Type "play" to play the game, "exit" to quit:')
if choices=='play':
    print('\n{}'.format(word))
    while lives>0:
        letter = input('Input a letter:')
        if len(letter)>1:
            print('You should input a single letter')

        elif not letter.isalpha():
            print('Please enter a lowercase English letter')
        elif letter.isupper():
            print('Please enter a lowercase English letter')
        elif letter in word and letter in guess or letter in not_word:
            print('You\'ve already guessed this letter')
        elif letter not in guess:
            print('That letter doesn\'t appear in the word')
            not_word=not_word+letter
            lives=lives-1
        elif letter in guess and letter not in word:
            indices=[i for i, x in enumerate(guess) if x == letter]
            for index in indices:
                word=word[:index]+letter+word[index+1:]
        if (word == guess):
            break
        if(lives!=0):
            print('\n{}'.format(word))

    if(word==guess):
        print('You guessed the word!\nYou survived!')
    else:
        print('You lost!')





