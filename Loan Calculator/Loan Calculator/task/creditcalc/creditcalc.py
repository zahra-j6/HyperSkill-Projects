import argparse,sys
import math

'''
loan_principal = 'Loan principal: 1000'
final_output = 'The loan has been repaid!'
first_month = 'Month 1: repaid 250'
second_month = 'Month 2: repaid 250'
third_month = 'Month 3: repaid 500'

# write your code here

#Objective 1: all you need to do is output them in the right order.
print(loan_principal)
print(first_month)
print(second_month)
print(third_month)
print(final_output)

#Objective 2
# ask the user to input the loan principal amount
amt=int(input())
#Then, the user should indicate what needs to be calculated (the monthly payment amount or the number of months) and enter the required parameter.
choice=input('What do you want to calculate? \ntype "m" - for number of monthly payments,\n type "p" - for the monthly payment:')
# After that, the loan calculator should output the value that the user wants to know

if choice=='m':
    monthly_pay=int(input('Enter the monthly payment:'))
    print('It will take ',round(amt/monthly_pay),' months to repay the loan')
else:
    months=int(input("Enter the number of months:"))
    payment = amt / months
    if(payment.is_integer()):
        print('Your monthly payment = ',payment)
    else:
        payment=math.ceil(payment)
        print('Your monthly payment = ',payment,' and the last payment =',amt-((months-1)*payment))

#Stage 3:Annuity payment
choice=input('What do you want to calculate?\ntype "n" for number of monthly payments,\ntype "a" for annuity monthly payment amount,\ntype "p" for loan principal:')
if choice=='n':
    principal=float(input("Enter loan principal"))
    m_pay=int(input("Enter monthly payment"))
    interest = float(input("Enter loan interest"))
    i=interest/1200
    n=math.log(m_pay/(m_pay- (i*principal)),(1+i))
    n=math.ceil(n)
    if(n%12==0):
        print('It will take ',n/12,' years to repay the loan!')
    else:
        print('It will take ',n//12,'years and ',n%12,' months to repay the loan!')
elif choice =='a':
    principal = float(input("Enter loan principal"))
    periods = int(input("Enter number of periods"))
    interest = float(input("Enter loan interest"))
    i = interest / 1200
    a=principal*((i*pow(1+i,periods))/(pow(1+i,periods)-1))
    print('The monthly payment is ',math.ceil(a),'!')
else:
    a = float(input("Enter annuity payment"))
    periods = float(input("Enter number of periods"))
    interest = float(input("Enter loan interest"))
    i = interest / 1200
    deno=(i*pow(1+i,periods))/(pow(1+i,periods)-1)
    print('Your loan principal =',round(a/deno),'!')
    
'''
#Stage 4
parser = argparse.ArgumentParser()
parser.add_argument("--type", type=str)
parser.add_argument("--payment", type=int)
parser.add_argument("--principal", type=int)
parser.add_argument("--periods", type=int)
parser.add_argument("--interest", type=float)
args = parser.parse_args()


def incorrect_params():
    print("Incorrect parameters")
    sys.exit(1)


if len(sys.argv) != 5 or args.interest is None:
    incorrect_params()
else:
    for v in vars(args).values():
        if type(v) in (int, float) and v < 0:
            incorrect_params()

    payment, principal, periods = args.payment, args.principal, args.periods
    nominal_interest = args.interest / (12 * 100)

    if args.type == "annuity":
        if args.payment and args.periods:
            principal = math.floor(
                args.payment
                / (
                    (nominal_interest * pow(1 + nominal_interest, periods))
                    / (pow(1 + nominal_interest, periods) - 1)
                )
            )

            print(f"Your loan principal = {principal}!")
        elif args.payment and args.principal:

            def convert_months_to_human(n_months):
                months = n_months % 12
                years = n_months // 12
                months_word, years_word = None, None

                if months == 1:
                    months_word = "month"
                elif months > 1:
                    months_word = "months"

                if years == 1:
                    years_word = "year"
                elif years > 1:
                    years_word = "years"

                if years and months:
                    return f"{years} {years_word} and {months} {months_word}"
                elif years:
                    return f"{years} {years_word}"
                elif months:
                    return f"{months} {months_word}"

            periods = math.ceil(
                math.log(
                    args.payment / (args.payment - nominal_interest * args.principal),
                    1 + nominal_interest,
                )
            )

            print(
                f"It will take {convert_months_to_human(periods)} to repay this loan!"
            )
        elif args.principal and args.periods:
            payment = math.ceil(
                args.principal
                * (
                    (nominal_interest * pow(1 + nominal_interest, periods))
                    / (pow(1 + nominal_interest, periods) - 1)
                )
            )

            print(f"Your annuity payment = {payment}!")

        print(f"Overpayment = {payment * periods - principal}")
    elif args.type == "diff":
        if args.payment:
            incorrect_params()
        else:
            total = 0

            for month in range(1, periods + 1):
                diff_payment = math.ceil(
                    principal / periods
                    + nominal_interest
                    * (principal - (principal * (month - 1) / periods))
                )

                total += diff_payment

                print(f"Month {month}: payment is {diff_payment}")

            print(f"\nOverpayment = {math.ceil(total) - principal}")
    else:
        incorrect_params()