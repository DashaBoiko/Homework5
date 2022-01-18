public class Client  extends User {


        private boolean memberOfClubOrNot;


        public Client(String firstName, String lastName, String login,
                      String password, boolean memberOfClubOrNot)
        {
            super(firstName, lastName, login, password);
            this.memberOfClubOrNot = memberOfClubOrNot;
        }




        public boolean getMemberOfClubOrNot()
        {
            return memberOfClubOrNot;
        }

        public void setMemberOfClubOrNot(boolean memberOfClubOrNot)
        {
            this.memberOfClubOrNot = memberOfClubOrNot;
        }



        public String toString()
        {

            String str = super.toString();
            str+="Club member : ";
            if(memberOfClubOrNot==true)str+= "Yes\n";
            else str+="No\n";


            return str;
        }


    public int getType()
    {
        return 2;
    }

    }

